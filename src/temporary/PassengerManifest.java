package temporary;

import java.util.Scanner;

public class PassengerManifest {
    static String command;
    static int availableSeat = -1; 
    static int seat; 
    
	static Scanner myScanner = new Scanner(System.in);
	
    static Passenger[] passengers = new Passenger[12];


    
	static void print(Passenger[] passengers) {
	    String header = "##### PASSENGER MANIFEST ######\n";
	    header += "SkyBox Ltd.\n";
	    header += "Seat\tName\t\tAge";
	    
	    String bottomBorder = "##### ##### ##### ##### ##### ###";
        System.out.println(header);
    	for(int i = 0; i < 12; i=i+1) {
            if (passengers[i] == null) {
                System.out.println("" + (i + 1) + " ");
            } else {
                System.out.println("" + (i + 1) + "\t" + passengers[i].getName() + "\t\t" + passengers[i].getAge());
            }
        }
    	System.out.println(bottomBorder);
    	return; 
	}
	static void insert(Passenger[] passengers, String name, int age) { 
		
//        System.out.print("name: ");
//        String name = myScanner.nextLine();
//        System.out.print("age: ");
//        int age = myScanner.nextInt();
//        myScanner.nextLine();
        availableSeat = -1;
        for(int i = 0; i < 12; i=i+1) {
            if (passengers[i] == null) {
                availableSeat = i;
                break;
            } 
        }
        Passenger passenger = new Passenger(name, age);
        passengers[availableSeat] = passenger; 
	}
	static void remove(Passenger[] passengers) {
		
        System.out.print("seat: ");
        seat = myScanner.nextInt();
        myScanner.nextLine();
        passengers[seat - 1] = null;
        availableSeat = -1;
	}
	static void rearrange(Passenger[] passengers) {
		
        System.out.print("first seat: ");
        seat = myScanner.nextInt();
        Passenger tmpSeat = passengers[seat - 1];
        System.out.println("second seat: ");
        int seat2 = myScanner.nextInt();
        myScanner.nextLine();
        passengers[seat - 1] = passengers[seat2 - 1];
        passengers[seat2 - 1] = tmpSeat; 
	}
	static void count(Passenger[] passengers) {
    	int occupied = 0; 
    	for(int i = 0; i < 12; i=i+1) {
            if (passengers[i] != null) {
                occupied++;
            }
        }
    	System.out.println("Number of passengers: " + occupied); 
	}
	static void rename(Passenger[] passengers) {
		
    	System.out.println("seat: "); 
    	seat = myScanner.nextInt();
    	myScanner.nextLine();
    	System.out.println("name: "); 
    	String newName = myScanner.nextLine();
    	passengers[seat - 1].setName(newName);
	}
	
	public static void main(String[] args) {
//		Scanner myScanner = new Scanner(System.in);
		
		/* frågor: hur hantera felaktig input? 
		 * Hur hantera när planet är fullt?  */
		
//	    Passenger[] passengers = new Passenger[12];
	    	passengers[0] = new Passenger("Bob", 18);
	    	passengers[3] = new Passenger("Erik", 13);
	    	passengers[4] = new Passenger("Sam", 18);
	    	passengers[5] = new Passenger("Max", 21);

//	    String command;
//	    int availableSeat = -1; 
//	    int seat;
	    
//	    String header = "##### PASSENGER MANIFEST ######\n";
//	    header += "SkyBox Ltd.\n";
//	    header += "Seat\tName\t\tAge";
//	    
//	    String bottomBorder = "##### ##### ##### ##### ##### ###";

	    
	   while (true) {
	        System.out.print("Type a command (print, insert, remove, rearrange, count, rename): ");
	        command = myScanner.nextLine();
	        
	        switch (command) {
	        case "print": 
	        	print(passengers);
//	            System.out.println(header);
//	        	for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] == null) {
//	                    System.out.println("" + (i + 1) + " ");
//	                } else {
//	                    System.out.println("" + (i + 1) + "\t" + passengers[i].getName() + "\t\t" + passengers[i].getAge());
//	                }
//	            }
//	        	System.out.println(bottomBorder);
	        	break; 
	        case "insert":	           
	        	System.out.print("name: ");
	            String name = myScanner.nextLine();
	            System.out.print("age: ");
	            int age = myScanner.nextInt();
	            myScanner.nextLine();
	        	insert(passengers, name, age);

//	            availableSeat = -1;
//	            for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] == null) {
//	                    availableSeat = i;
//	                    break;
//	                } 
//	            }
//	            Passenger passenger = new Passenger(name, age);
//	            passengers[availableSeat] = passenger; 
	            break; 
	        case "remove":
	        	remove(passengers);
//	            System.out.print("seat: ");
//	            seat = myScanner.nextInt();
//	            myScanner.nextLine();
//	            passengers[seat - 1] = null;
//	            availableSeat = -1;
	            break; 
	        case "rearrange": 
	        	rearrange(passengers);
//	            System.out.print("first seat: ");
//	            seat = myScanner.nextInt();
//	            Passenger tmpSeat = passengers[seat - 1];
//	            System.out.println("second seat: ");
//	            int seat2 = myScanner.nextInt();
//	            myScanner.nextLine();
//	            passengers[seat - 1] = passengers[seat2 - 1];
//	            passengers[seat2 - 1] = tmpSeat; 
	            break; 
	        case "count":
	        	count(passengers);
//	        	int occupied = 0; 
//	        	for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] != null) {
//	                    occupied++;
//	                }
//	            }
//	        	System.out.println("Number of passengers: " + occupied); 
	        	break; 
	        case "rename":
	        	rename(passengers);
//	        	System.out.println("seat: "); 
//	        	seat = myScanner.nextInt();
//	        	myScanner.nextLine();
//	        	System.out.println("name: "); 
//	        	String newName = myScanner.nextLine();
//	        	passengers[seat - 1].setName(newName);
	        	break; 
	        default: 
	        	System.out.println("Unknown command");
	        	break;
	            
	        }
//	        if (command.equals("print")) {
//	            System.out.println(header);
//	        	for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] == null) {
//	                    System.out.println("" + (i + 1) + " ");
//	                } else {
//	                    System.out.println("" + (i + 1) + "\t" + passengers[i].getName() + "\t\t" + passengers[i].getAge());
//	                }
//	            }
//	        	System.out.println(bottomBorder);
	      //  {
//	        else if (command.equals("insert")) {
//	            System.out.print("name: ");
//	            String name = myScanner.nextLine();
//	            System.out.print("age: ");
//	            int age = myScanner.nextInt();
//	            myScanner.nextLine();
//	            int availableSeat = -1;
//	            for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] == null) {
//	                    availableSeat = i;
//	                    break;
//	                } 
//	            }
//	            for(int i = -1; i <= 0; i=i+1) {
//	            	System.out.println("full");
//	            	break; 
//	            }
	            // check if avaliableSeat is not -1, else no seat available

//	            else if(i > 12) {
//                	
//                	System.out.println("No seats available.");
//                }
//	            Passenger passenger = new Passenger(name, age);
//	            passengers[availableSeat] = passenger; 
////	        }
//	        else if (command.equals("remove")) {
//	            System.out.print("seat: ");
//	            int seat = myScanner.nextInt();
//	            myScanner.nextLine();
//	            passengers[seat - 1] = null;
//	            int availableSeat = -1;
//	        }else if(command.equals("switch seats")) {
//	            System.out.print("first seat: ");
//	            int seat = myScanner.nextInt();
//	           // myScanner.nextLine();
//	            Passenger tmpSeat = passengers[seat - 1];
//	            System.out.println("second seat: ");
//	            int seat2 = myScanner.nextInt();
//	            myScanner.nextLine();
//	            passengers[seat - 1] = passengers[seat2 - 1];
//	            passengers[seat2 - 1] = tmpSeat; 
	            
//	        } else if(command.equals("count")) {
//	        	int occupied = 0; 
//	        	for(int i = 0; i < 12; i=i+1) {
//	                if (passengers[i] != null) {
//	                    occupied++;
//	                }
//	            }
//	        	System.out.println("Number of passengers: " + occupied); 
//	        } else if (command.equals("rename")) {
//	        	System.out.println("seat: "); 
//	        	int seat = myScanner.nextInt();
//	        	myScanner.nextLine();
//	        	System.out.println("name: "); 
//	        	String newName = myScanner.nextLine();
//	        	passengers[seat - 1].setName(newName);
//	        }
//	        else {
//	            System.out.println("Unknown command");
//	        }
	      }
		
	}

}
