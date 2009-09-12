/*
 * Copyright 2003-2009 OFFIS, Henri Tremblay
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easymock.tests;

import static org.junit.Assert.*;

import org.easymock.internal.ArgumentToString;
import org.junit.Before;
import org.junit.Test;

public class ArgumentToStringTest {

    private StringBuffer buffer;

    @Before
    public void setUp() {
        buffer = new StringBuffer();
    }
    
    @Test
    public void testAppendArgument_null() {
        assertString("null", null);
    }

    @Test
    public void testAppendArgument_String() {
        assertString("\"hello\"", "hello");
    }

    @Test
    public void testAppendArgument_Character() {
        assertString("'c'", Character.valueOf('c'));
    }

    @Test
    public void testAppendArgument_Array() {
        assertString("[\"a\", \"b\"]", new String[] { "a", "b" });
    }

    @Test
    public void testAppendArgument_Full() {
        assertString("[3, 4, [\"a\", \"b\"], null]", new Object[] { 3, 4,
                new String[] { "a", "b" }, null });
    }
    
    private void assertString(String expected, Object actual) {
        ArgumentToString.appendArgument(actual, buffer);
        assertEquals(expected, buffer.toString());
    }
}