package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.SORT_ASCENDING;
import static seedu.address.logic.commands.CommandTestUtil.SORT_DESCENDING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_DIRECTION_ASCENDING;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SORT_DIRECTION_DESCENDING;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getUnsortedTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SortCommand.
 */
public class SortCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getUnsortedTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_sortListInAscendingOrder_success() {
        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS,
                VALID_SORT_DIRECTION_ASCENDING);
        assertCommandSuccess(new SortCommand(SORT_ASCENDING), model,
                expectedMessage, expectedModel);
    }

    @Test void execute_sortListInDescendingOrder_success() {
        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS,
                VALID_SORT_DIRECTION_DESCENDING);
        expectedModel.sortByName(false);
        assertCommandSuccess(new SortCommand(SORT_DESCENDING), model,
                String.format(SortCommand.MESSAGE_SUCCESS, "descending"), expectedModel);
    }
}
