import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinarySearchTests {

    private static final int[] ONE_ELEMENT_SEQUENCE = {2};
    private static final int[] MULTI_ELEMENT_SEQUENCE = {-3, 0, 1, 2, 3, 4, 7, 10};
    private static final BinarySearch BINARY_SEARCH = BinarySearch.create();

    @Test void searchForElementInSequence() {
        final int KEY = 2;
        final int EXPECTED_POSITION = 0;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, ONE_ELEMENT_SEQUENCE);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), EXPECTED_POSITION);
        Assertions.assertEquals(ONE_ELEMENT_SEQUENCE[searchResult.getPosition()], KEY);
    }

    @Test void searchForElementNotInSequence() {
        final int KEY = 1;
        final int EXPECTED_POSITION = -1;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, ONE_ELEMENT_SEQUENCE);

        Assertions.assertFalse(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), EXPECTED_POSITION);
    }

    @Test void searchForElementAtFirstPositionInMultiSequence() {
        final int KEY = -3;
        final int EXPECTED_POSITION = 0;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, MULTI_ELEMENT_SEQUENCE);

        Assertions.assertTrue(searchResult.isFound());
        Assertions.assertEquals(searchResult.getPosition(), EXPECTED_POSITION);
        Assertions.assertEquals(MULTI_ELEMENT_SEQUENCE[searchResult.getPosition()], KEY);
    }
}
