/*Sri Vihaan Travels announced a family trip to Sri Nagar, for which they began 
taking reservations. They are only offering 2 and 3-seater tickets for this trip.

Each member of certain groups is identifiable by the group ID to which he or 
she belongs. Each group is uniquely identified by its group ID.

The travel administration decided that the ticket will only be issued to members
of the same group. It is decided that No wasted tickets will be issued 
(i.e., If a person is alone, then he is not allowed to get a ticket).

You are given a list of integers person_id[], where person_id[i] is the group ID 
of the ith person in the list. Your objective is to determine whether fewer tickets 
should be issued to cover everyone in each group. Print -1, if it is not possible.


Input Format:
-------------
Line-1: Comma separated integers, Person's group-ID

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
1,1,3,2,2,2,1,2,2,3

Sample Output-1:
----------------
4

Explanation: 
------------
They can book the tickets for all the people, as follows:
- Issue the 3-seater ticket, to group with ID-1 of size 3.
- Issue the 2-seater ticket, to group with ID-3 of size 2.
- Issue the 3-seater ticket, to group with ID-2 of size 5.
- Issue the 2-seater ticket, to group with ID-2 of size 5.
So, you have issued 4 tickets in total.


Sample Input-2:
---------------
1,1,1,2,2,3

Sample Output-2:
----------------
-1

Explanation: 
------------
There is a group with ID-3 of size 1. 
The administration's ruling states that a single person cannot receive a ticket.
So, print -1. */




import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] personIds = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            personIds[i] = Integer.parseInt(input[i]);
        }
        System.out.println(minTickets(personIds));
    }

    public static int minTickets(int[] personIds) {
        Map<Integer, Integer> groupSizes = new HashMap<>();
        for (int id : personIds) {
            groupSizes.put(id, groupSizes.getOrDefault(id, 0) + 1);
        }

        int count = 0;
        for (int size : groupSizes.values()) {
            if (size == 1) {
                // If any group has only one member, it's not possible to issue a ticket.
                return -1;
            }
            if (size == 2 || size == 3) {
                // If a group size is 2 or 3, issue one ticket for that group.
                count++;
            } else {
                // If a group size is greater than 3, issue tickets in multiples of 3 and 2.
                count += (size / 3) + ((size % 3) > 0 ? 1 : 0);
            }
        }
        return count;
    }
}