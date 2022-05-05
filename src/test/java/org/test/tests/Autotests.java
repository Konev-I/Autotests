package org.test.tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.test.tests.login.LoginTest;
import org.test.tests.message.MessageSendingTest;
import org.test.tests.post.NoteCreationTest;
import org.test.tests.post.PostReactionTest;

@Suite
@SelectClasses({LoginTest.class, NoteCreationTest.class, MessageSendingTest.class, PostReactionTest.class})
public class Autotests {}
