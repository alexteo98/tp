package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterSkillCommand;
import seedu.address.model.person.PersonContainsSkillPredicate;
import seedu.address.model.tag.Skill;

class FilterSkillCommandParserTest {

    private FilterSkillCommandParser parser = new FilterSkillCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterSkillCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFilterSkillCommand() {
        // no leading and trailing whitespaces
        FilterSkillCommand expectedFilterSkillCommand =
                new FilterSkillCommand(new PersonContainsSkillPredicate(new Skill("C")));
        assertParseSuccess(parser, "C", expectedFilterSkillCommand);
    }
}