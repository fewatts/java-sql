import java.util.Arrays;
import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        double numberOfPagesDouble = (double) collection.size() / itemsPerPage;
        return (int) Math.ceil(numberOfPagesDouble);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int pageCount = pageCount();
        if (pageIndex < 0 || pageIndex >= pageCount)
            return -1;

        int startIndex = pageIndex * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, collection.size());

        return endIndex - startIndex;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= itemCount()) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.pageCount());
        System.out.println(helper.itemCount());
        System.out.println();
        System.out.println(helper.pageItemCount(0));
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageItemCount(2));
    }

}