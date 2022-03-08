package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SortCommand;
import seedu.address.model.person.PersonBySkillProficiencyComparator;
import seedu.address.model.person.PersonContainsSkillPredicate;
import seedu.address.model.tag.Skill;

import java.util.HashSet;

class SortCommandParserTest {

    private final SortCommandParser parser = new SortCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsSortCommand() {
        Skill skill = new Skill("Java");
        HashSet<Skill> skillSet = new HashSet<>();
        skillSet.add(skill);

        SortCommand expectedSortCommand = new SortCommand(new PersonContainsSkillPredicate(skillSet),
            new PersonBySkillProficiencyComparator(skill));

        assertParseSuccess(parser, "Java", expectedSortCommand);
    }
}
