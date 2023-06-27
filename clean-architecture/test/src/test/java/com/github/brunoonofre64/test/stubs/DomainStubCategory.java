package com.github.brunoonofre64.test.stubs;

import com.github.brunoonofre64.domain.entities.Category;

import java.util.ArrayList;

import static com.github.brunoonofre64.test.UnitTestConstants.TEXT_DEFAULT;
import static com.github.brunoonofre64.test.UnitTestConstants.UUID_DEFAULT;

public class DomainStubCategory {

    public static Category buildCategory() {
        return new Category(UUID_DEFAULT, TEXT_DEFAULT, new ArrayList<>());
    }
}
