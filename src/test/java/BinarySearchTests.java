import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTests {

    private static final int[] SEARCH_SEQUENCE = {2};
    private static final BinarySearch BINARY_SEARCH = BinarySearch.create();

    @Test void searchForElementInSequence() {
        final int KEY = 2;
        final int EXPECTED_POSITION = 0;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, SEARCH_SEQUENCE);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), EXPECTED_POSITION);
        Assertions.assertEquals(SEARCH_SEQUENCE[searchResult.getPosition()], KEY);
    }

    @Test void searchForElementNotInSequence() {
        final int KEY = 1;
        final int EXPECTED_POSITION = -1;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, SEARCH_SEQUENCE);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), EXPECTED_POSITION);
    }
}
