# The Production RAG/Agentic AI Handbook
### A practical checklist to work through before shipping any RAG or agentic system

---

## How to use this handbook

Work through the phases **in order**. Each phase has a **gate** — a condition that must be true before you move to the next one. Skipping a gate is how demos silently become unreliable production systems. This is not a one-time checklist; re-run Phase 0 and Phase 5 every time you make a meaningful change.

---

## Phase 0 — Before you write any pipeline code

**Goal: know what "good" means before you build anything.**

- [ ] Write down the exact task(s) the system must perform, in plain language
- [ ] Decide what "success" looks like per task — factual accuracy, task completion, tone, format
- [ ] Collect 50-200 real or realistic queries covering: easy cases, multi-hop cases, ambiguous cases, and "no good answer exists" cases
- [ ] For each query, label the gold answer and/or gold source chunks
- [ ] Decide your latency and cost budget per request *now* — it constrains every downstream choice (model size, reranking, step limits)
- [ ] Decide autonomy level needed: fixed pipeline vs. bounded agent vs. open-ended agent (default to the most constrained option that solves the task)

**Gate:** You have a labeled eval set and a defined budget before writing ingestion code.

---

## Phase 1 — Data pipeline & retrieval

**Goal: retrieval that's measurably good, not just "looks reasonable in a demo."**

### Ingestion
- [ ] Use format-aware parsing (tables, headers, figures preserved) — not raw text dumps
- [ ] Extract and attach metadata at ingestion: source, date, author, section, permissions
- [ ] Deduplicate near-identical content
- [ ] Make ingestion idempotent and incremental (re-running doesn't duplicate; updates replace)

### Chunking
- [ ] Use structure-aware chunking (by heading/section/function), not fixed-size-only splitting
- [ ] Prepend hierarchical context (doc title, section) to each chunk before embedding
- [ ] Test 2-3 chunk sizes against your eval set — pick empirically, not by default

### Embedding & indexing
- [ ] Benchmark 2-3 embedding models against your eval set for your specific content type
- [ ] Add hybrid search (dense + BM25/sparse), merged via reciprocal rank fusion
- [ ] Add a reranking stage on top-30-50 candidates → top 5-10
- [ ] Add metadata pre-filtering (date, source, **permissions**)
- [ ] Add query rewriting for conversational/ambiguous queries

**Gate:** Recall@k and MRR on your eval set meet a defined bar (e.g., recall@5 > 90% for easy cases) before you build generation on top of it.

---

## Phase 2 — Eval harness & observability

**Goal: you can prove a change made things better, not just believe it did.**

- [ ] Separate metrics into three layers: retrieval quality, generation-given-correct-context quality, end-to-end quality
- [ ] Build an automated eval pipeline that runs the full eval set on demand and diffs against the previous run
- [ ] Set up LLM-as-judge with explicit rubrics (not vague "rate 1-5"), calibrated against ~50-100 human labels
- [ ] Gate every deploy on this: no prompt/model/pipeline change ships without a full eval run
- [ ] Instrument full request tracing: query → retrieved chunks + scores → final prompt → tool calls → output, all under one trace ID
- [ ] Track production metrics continuously: latency per step, cost per request, retrieval score distribution, error rates
- [ ] Build a feedback loop: flagged/negative-feedback interactions → human review → added to eval set

**Gate:** You can run one command and get a pass/fail signal with a diff against baseline for any change.

---

## Phase 3 — Agent orchestration & tool design *(skip if pure RAG, no agentic actions)*

**Goal: bounded, debuggable, recoverable behavior — not an open-ended loop.**

- [ ] Model control flow as an explicit graph/state machine, not a single freeform loop
- [ ] Set hard limits: max steps, max tool calls (per tool and total), token/cost budget, wall-clock timeout
- [ ] Design tools narrow and single-purpose, with tight types/enums over free text
- [ ] Write tool descriptions like documentation: what it does, when to use it, when not to, example inputs
- [ ] Cap active tools per context (~15-20); use a router/category step if you have more
- [ ] Return structured, truncated tool outputs with actionable error messages
- [ ] Build retry/backoff for transient failures, circuit breakers for repeated failures
- [ ] Require explicit human confirmation before any irreversible/high-stakes action
- [ ] Treat all tool-fetched content as untrusted input — never as new instructions
- [ ] Add injection-attempt cases to your eval set

**Gate:** The system cannot loop forever, cannot silently blow your cost budget, and cannot take an irreversible action without a checkpoint.

---

## Phase 4 — Prompting & the LLM call

**Goal: consistent, grounded, structurally reliable output.**

- [ ] Version prompts in source control; every change goes through eval-gating like code
- [ ] Put stable rules in the system prompt; keep it lean — avoid instruction pile-up
- [ ] Use schema-constrained structured output wherever downstream code consumes the result
- [ ] Build a validation + repair loop for malformed structured output (bounded retries, then safe fallback)
- [ ] Add an explicit grounding contract: "answer only from provided context" + explicit refusal instruction when the answer isn't present
- [ ] Test refusal behavior against empty/no-answer cases in your eval set
- [ ] Route steps to different model sizes deliberately (cheap model for routing/extraction, strong model for synthesis/reasoning) — verify with eval data, not intuition
- [ ] Pin model versions per environment; re-run eval before any model upgrade
- [ ] Set temperature and max tokens intentionally per step (low temp for factual/extraction tasks)

**Gate:** Structured output validation failure rate and refusal-on-no-answer rate are both measured and acceptable on your eval set.

---

## Phase 5 — UI/API layer

**Goal: the backend's reliability actually reaches the user.**

- [ ] Define a versioned API contract (request/response schema) before building the UI
- [ ] Support streaming: tokens for generation, status events for agent steps
- [ ] Use an async job pattern (submit → poll/subscribe) for tasks that may run long, with cancellation support
- [ ] Surface citations/sources in the UI, clickable and verifiable
- [ ] Distinguish grounded vs. low-confidence answers visually
- [ ] Build explicit confirmation UX for any human-in-the-loop action, showing the real action/parameters
- [ ] Enforce auth and permission-scoped retrieval at the API boundary — never trust upstream filtering alone
- [ ] Rate-limit per user/tenant with clear retry guidance
- [ ] Propagate trace IDs through the API layer for observability

**Gate:** A user can see why an answer was given (citations/trace) and can stop or undo a running task.

---

## The non-negotiables (if you do nothing else, do these)

1. **A labeled eval set**, however small, before you tune anything
2. **Hybrid search + reranking** — the single highest-ROI retrieval fix
3. **Explicit refusal behavior** tested against no-answer queries — this is your main hallucination defense
4. **Hard step/cost/time limits** on any agentic loop
5. **Full request tracing** so any bad output is reproducible and debuggable
6. **Human confirmation** before irreversible actions

---

## Effort allocation to expect

| Phase | Typical share of total effort |
|---|---|
| Data pipeline & retrieval | 35–40% |
| Eval harness & observability | 20–25% |
| Agent orchestration & tool design | 15–20% |
| Prompting & the LLM call | ~10% |
| UI/API layer | ~10% |

If your actual time is being spent in the inverse of this order — mostly on prompts and UI, barely any on retrieval and eval — that's a signal you're building a demo, not a production system.

---

## Recurring cadence once live

- **Every change:** automated eval run, gated deploy
- **Daily/weekly:** metric dashboard review (latency, cost, error rates, retrieval score drift)
- **Weekly:** human review of sampled production traces; expand eval set with new confirmed failures
- **Monthly / on model change:** recalibrate LLM-as-judge against fresh human labels
