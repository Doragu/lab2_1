import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BinarySearchTests {

    private static final int[] EMPTY_SEQUENCE = {};
    private static final int[] NULL_SEQUENCE = null;
    private static final int[] ONE_ELEMENT_SEQUENCE = {2};
    private static final int[] MULTI_ELEMENT_SEQUENCE = {-3, 0, 1, 2, 3, 4, 7, 10};
    private static final BinarySearch BINARY_SEARCH = BinarySearch.create();
    private static final int NOT_FOUND_POSITION = -1;

    @Test void searchForElementInSequence() {
        final int KEY = 2;
        final int EXPECTED_POSITION = 0;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, ONE_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(EXPECTED_POSITION));
        assertThat(ONE_ELEMENT_SEQUENCE[searchResult.getPosition()], is(KEY));
    }

    @Test void searchForElementNotInSequence() {
        final int KEY = 1;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, ONE_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(NOT_FOUND_POSITION));
    }

    @Test void searchForElementAtFirstPositionInMultiSequence() {
        final int KEY = -3;
        final int EXPECTED_POSITION = 0;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, MULTI_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(EXPECTED_POSITION));
        assertThat(MULTI_ELEMENT_SEQUENCE[searchResult.getPosition()], is(KEY));
    }

    @Test void searchForElementAtLastPositionInMultiSequence() {
        final int KEY = 10;
        final int EXPECTED_POSITION = 7;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, MULTI_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(EXPECTED_POSITION));
        assertThat(MULTI_ELEMENT_SEQUENCE[searchResult.getPosition()], is(KEY));
    }

    @Test void searchForElementAtMiddlePositionInMultiSequence() {
        final int KEY = 2;
        final int EXPECTED_POSITION = 3;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, MULTI_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(EXPECTED_POSITION));
        assertThat(MULTI_ELEMENT_SEQUENCE[searchResult.getPosition()], is(KEY));
    }

    @Test void searchForElementNotInMultiSequence() {
        final int KEY = 5;

        SearchResult searchResult = BINARY_SEARCH.search(KEY, MULTI_ELEMENT_SEQUENCE);

        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(NOT_FOUND_POSITION));
    }

    @Test void searchForElementInEmptySequence() {
        final int KEY = 5;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BINARY_SEARCH.search(KEY, EMPTY_SEQUENCE);
        });
    }

    @Test void searchForElementInNullSequence() {
        final int KEY = 5;

        Assertions.assertThrows(NullPointerException.class, () -> {
            BINARY_SEARCH.search(KEY, NULL_SEQUENCE);
        });
    }

    @Test void searchForNullElementInSequence() {
        final Integer KEY = null;

        Assertions.assertThrows(NullPointerException.class, () -> {
            BINARY_SEARCH.search(KEY, ONE_ELEMENT_SEQUENCE);
        });
    }
}
