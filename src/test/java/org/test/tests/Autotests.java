package org.test.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginTest.class, NoteCreationTest.class, MessageSendingTest.class})
public class Autotests {}
