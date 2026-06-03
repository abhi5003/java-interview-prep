Design ParkingLot 

Requirement gathering :
1. Parking lot having multiple floor
2. Parking lot having different-different type of parking slot based upon vehicle size
3. Parking lot having multiple entery/exit gate
4. It supports cocurrent slot booking
5. Ticket will generate on entry gate and payment on exit gate 

Identifying the entity classes :
1. ParkingLot (Main class ) : It would be singleton
2. ParkingFloor (class)
3. ParkingSpot (class)
4. EntryGate (class)
5. ExitGate (class)
6. Ticket (class)
7. ParkingStrategy (interface) 
8. PaymentStrategy (interface)
9. Vehicle (Abstract class)
10. VehicleType (enum)