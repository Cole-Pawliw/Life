import java.util.Arrays;
import java.util.Scanner;

/*
 * Cole Pawliw
 * Nov 6, 2017
 * A program simulating the game Life by John Conway
 */

public class Life {
    
    /**
     *Prints out the game grid
     *pre: the grid array
     *post: prints out each line of the array
     */
    public static void printArray(char[][] array) {
        
        for (int print = 0; print < array.length; print++) {
            System.out.println(array[print]);
        }
        System.out.println("\n\n\n");
    }
    
    /**
     *Changes any values from X to O or O to X when necessary
     *pre: the grid array
     *post: changes original grid to a new day grid
     *WARNING: VERY LONG
     */
    public static char[][] change(char[][] array) {
        
        int neighbors;
        
        for (int i = 0; i < 20; i++) {
            for (int o = 0; o < 20; o++) {
                
                neighbors = 0;
                
                /*
                 * All these if's check if the surrounding cells are X's
                 * If they ARE X's, it increases the neighbor count by 1
                 * 
                 * Many must be repeated because cells around the border
                 * would otherwise cause a problem
                 * 
                 * Negative means subtract and positive means add
                 */
                if (i == 0) { //i can't be negative
                    if (o == 0) { //o can't be negative
                        if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o+1] == 'X' || array[i+1][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        
                    } else if (o == 19) { //o can't be positive
                        if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o-1] == 'X' || array[i+1][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        
                    } else { //o can be anything
                        if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o-1] == 'X' || array[i+1][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i+1][o+1] == 'X' || array[i+1][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                    }
                    
                    
                } else if (i == 19) { //i can't be positive
                    if (o == 0) { //o can't be negative
                        if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i-1][o+1] == 'X' || array[i-1][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        
                    } else if (o == 19) { //o can't be positive
                        if (array[i-1][o-1] == 'X' || array[i-1][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        
                    } else { //o can be anything
                        if (array[i-1][o-1] == 'X' || array[i-1][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                        if (array[i-1][o+1] == 'X' || array[i-1][o+1] == 'W') {
                            neighbors = neighbors + 1;
                        }
                    }
                    
                    
                } else if (o == 0) { //i can be anything but o can't be negative
                    if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i-1][o+1] == 'X' || array[i-1][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o+1] == 'X' || array[i+1][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    
                    
                } else if (o == 19) { //i can be anything but o can't be positive
                    if (array[i-1][o-1] == 'X' || array[i-1][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o-1] == 'X' || array[i+1][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    
                    
                } else { //both i and o can be anything
                    if (array[i-1][o-1] == 'X' || array[i-1][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i][o-1] == 'X' || array[i][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i-1][o] == 'X' || array[i-1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o] == 'X' || array[i+1][o] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i][o+1] == 'X' || array[i][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i-1][o+1] == 'X' || array[i-1][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o-1] == 'X' || array[i+1][o-1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                    if (array[i+1][o+1] == 'X' || array[i+1][o+1] == 'W') {
                        neighbors = neighbors + 1;
                    }
                }
                
                
                
                
                if (array[i][o] == 'X') {
                    if (neighbors < 2 || neighbors > 3) {
                        array[i][o] = 'W'; //This is to help keep track of which were alive the day before, before dying
                    }
                } else if (array[i][o] == 'O') {
                    if (neighbors == 3) {
                        array[i][o] = 'E'; //This is the same as the W, but for those that become alive
                    }
                }
            }
        }
        
        for (int changeRow = 0; changeRow < 20; changeRow++) {
            for (int changeColumn = 0; changeColumn < 20; changeColumn++) {
                if (array[changeRow][changeColumn] == 'W') {
                    array[changeRow][changeColumn] = 'O';
                } else if (array[changeRow][changeColumn] == 'E') {
                    array[changeRow][changeColumn] = 'X';
                }
            }
        }
        
        return array;
    }
    
    /**
     * Checks to see if there are still living cells
     * pre: the grid array
     * post: returns the number of live cells
     */
    public static int check(char[][] array) {
        
        int counter = 0;
        
        for (int i = 0; i < 20; i++) {
            for (int o = 0; o < 20; o++) {
                if (array[i][o] == 'X') {
                    counter = counter + 1;
                }
            }
        }
        return counter;
    }
    
    /**
     *Gets inputs for new cells and keeps track of days
     */
    public static void main(String args[]) {
        
        char[][] grid = new char[20][20];
        char o = 'O';
        int pos1;
        int pos2;
        int day = 1;
        int alive;
        String yesNo;
        String again;
        
        for (int fill = 0; fill < 20; fill++) {
            Arrays.fill(grid[fill], o);
        }
        
        System.out.println("Welcome to Life. Currently every cell in this 20x20 grid is dead.");
        printArray(grid);
        System.out.println("Please select the coordinates of each cell you would like to become alive.");
        
        Scanner input = new Scanner(System.in);
        
        
        do {
            do {
                System.out.print("Coordinate 1 (1-20): ");
                pos1 = input.nextInt();
            } while (pos1 < 0 || pos1 > 20);
            do {
                System.out.print("Coordinate 2 (1-20): ");
                pos2 = input.nextInt();
            } while (pos2 < 0 || pos2 > 20);
            input.nextLine();
            
            grid[pos1 - 1][pos2 - 1] = 'X';
            System.out.println("The cell at position " + pos1 + ", " + pos2 + " is now alive.");
            System.out.print("Would you like to make another cell alive? (y/n): ");
            yesNo = input.nextLine();
        } while (yesNo.equals("y")); //Allows input of another cell
        
        System.out.println("Day " + day);
        printArray(grid);
        day = day + 1;
        
        do {
            System.out.println("Day " + day);
            grid = change(grid);
            printArray(grid);
            day = day + 1;
            
            alive = check(grid);
            
            System.out.print("Play next day?(y/n): ");
            again = input.nextLine();
        } while (again.equals("y") && alive > 0);
        
        if (alive == 0) {
            System.out.println("All the cells have died... Game over");
        }
    }
}
