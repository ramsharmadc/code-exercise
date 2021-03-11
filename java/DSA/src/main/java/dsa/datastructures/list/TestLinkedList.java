package dsa.datastructures.list;

public class TestLinkedList {
    public static void main(final String[] args) {
        final LinkedList<Integer> list = new LinkedList<>();
        try {
            list.insert(12);
            list.setHead(list.getHead());
            // insert functionality
            list.insert(15);
            list.insert(14);
            list.insert(13);
            list.insert(21);
            list.insert(9);
            list.insert(91);
            list.insert(17);
            list.insert(18);
            list.insert(11);
            list.insertAt(16, 4);
            // delete functionality
            list.delete(4);
            // list.deleteLast(); // ## having some issue in this method ##
            list.deleteFirst();

            // list.showList();

            // System.out.println("length: " + list.length());
            // System.out.println("Is List empty ? " + list.isEmpty());

            final LinkedList<Integer> newList = new LinkedList<>();

            // System.out.print("List 2: ");
            newList.addAll(list);
            // newList.showList();
            // System.out.println("length: " + newList.length());
            // System.out.println("Is List empty ? " + newList.isEmpty());

            // sorting the list
            newList.sort(LinkedList.OrderBy.ASC);
            // newList.showList();

            newList.sort(LinkedList.OrderBy.DESC);
            // newList.showList();

            final LinkedList<Integer> oneMoreList = new LinkedList<Integer>();
            oneMoreList.insert(new Integer[]{3, 5, 1, 12, 56, 45, 78, 9, 34, 56});
            // oneMoreList.sort();
            oneMoreList.showList();

            final LinkedList<String> oneMoreListOfString = new LinkedList<>();
            oneMoreListOfString
                    .insert(new String[]{"3", "5", "1", "12", "56", "45", "78", "9", "34", "56"});

            // TODO implement sorting with other than Integer
            // oneMoreListOfString.insert(new String[]{"Ram","Sharma"}); // NOT
            // IMPLEMENTED... will throw
            // Exception
            // oneMoreListOfString.sort();
            // oneMoreListOfString.showList();

            oneMoreList.sort(LinkedList.OrderBy.DESC);

            oneMoreList.showList();

            oneMoreList.reverse();
            oneMoreList.showList();

        } catch (final Exception e) {

            System.out.println("Error occurred:: " + e.toString());
        }

    }
}
