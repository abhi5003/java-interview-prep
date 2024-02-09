package abhi.java.code.design_Patterns.CommandDesignPattern;

import java.util.ArrayDeque;
import java.util.Stack;

public class MyRemoteControl {

    Stack<ICommand> acCommandHistory=new Stack<>();
    ICommand iCommand;
    public MyRemoteControl() {

    }

    public void setCommand(ICommand iCommand){
        this.iCommand=iCommand;
    }

    public void pressButton(){
        iCommand.excute();
        acCommandHistory.push(iCommand);
    }


    public void undo(){
        if(!acCommandHistory.isEmpty()){
            ICommand lastCommand=acCommandHistory.pop();
            lastCommand.undo();
        }
    }

}
