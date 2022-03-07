package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.HashSet;

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
        Skill skill1 = new Skill("C");
        HashSet skillSet1 = new HashSet<>();
        skillSet1.add(skill1);
        FilterSkillCommand expectedFilterSkillCommand =
                new FilterSkillCommand(new PersonContainsSkillPredicate(skillSet1));
        assertParseSuccess(parser, "C", expectedFilterSkillCommand);
    }
}
