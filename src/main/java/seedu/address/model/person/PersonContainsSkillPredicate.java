package seedu.address.model.person;

import java.util.Set;
import java.util.function.Predicate;

import seedu.address.model.tag.Skill;

/**
 * Tests that a {@code Person}'s {@code Skill} matches any of the keywords given.
 */
public class PersonContainsSkillPredicate implements Predicate<Person> {
    private final Set<Skill> skillSet;

    public PersonContainsSkillPredicate(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }

    @Override
    public boolean test(Person person) {
        return person.hasSkillSet(this.skillSet);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PersonContainsSkillPredicate // instanceof handles nulls
                && skillSet.equals(((PersonContainsSkillPredicate) other).skillSet)); // state check
    }

}
