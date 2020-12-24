import java.util.ArrayList;

class main {
    public static void main(String[] args) {
        ArrayList<Integer> MyArr = new ArrayList<>();
        MyArr.add(423);
        MyArr.add(323);
        MyArr.add(689);
        WaitList<Integer> list0 = new WaitList<>(MyArr);
        System.out.println("WaitList: ");
        System.out.println("\t" + list0.toString());
        System.out.println("Element " + list0.remove() + " was deleted");
        if (list0.contains(123)) {
            System.out.println("List contains \"123\"");
        }
        MyArr = new ArrayList<>();
        MyArr.add(123);
        MyArr.add(789);
        if (list0.containsAll(MyArr)) {
            System.out.println("and \"123\" И \"789\"");
        }
        if (!list0.isEmpty()) {
            System.out.println("List is not empty!\n");
        }
        BoundedWaitList<Character> list1 = new BoundedWaitList<>(5);
        System.out.print("Size of new limited capacity waitlist: ");
        System.out.println(list1.getCapacity());
        list1.add('g');
        list1.add('f');
        list1.add('g');
        list1.add('d');
        list1.add('h');
        list1.add('t');
        System.out.println("Wait list after adding values:");
        System.out.println("\t" + list1.toString() + "\n");
        UnfairWaitList<Boolean> list2 = new UnfairWaitList<>();
        list2.add(false);
        list2.add(true);
        list2.add(false);
        list2.add(false);
        System.out.println("\"Unfair\" wait list before moving item to end:");
        System.out.println("\t" + list2.toString());
        list2.moveToBack(true);
        System.out.println("After moving the element to the end:");
        System.out.println("\t" + list2.toString());
    }
}