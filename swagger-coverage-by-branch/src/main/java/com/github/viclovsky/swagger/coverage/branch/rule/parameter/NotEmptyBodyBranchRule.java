package com.github.viclovsky.swagger.coverage.branch.rule.parameter;

import com.github.viclovsky.swagger.coverage.branch.model.Branch;
import com.github.viclovsky.swagger.coverage.branch.predicate.BranchPredicate;
import com.github.viclovsky.swagger.coverage.branch.predicate.SimpleBodyBranchPredicate;
import com.github.viclovsky.swagger.coverage.branch.rule.parameter.ParameterRule;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;

public class NotEmptyBodyBranchRule extends ParameterRule {
    @Override
    public Branch processParameter(Parameter parameter) {
        if (parameter instanceof BodyParameter) {
            Branch branch = new Branch(
                    "Not empty body request",
                    ""
            );

            BranchPredicate predicate = new SimpleBodyBranchPredicate();
            branch.addPredicate(predicate);

            return branch;
        }

        return null;
    }
}
