package com.lhjz.portal.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lhjz.portal.Application;

@SpringApplicationConfiguration(classes = Application.class)
public class ScheduleRepositoryTest extends AbstractTestNGSpringContextTests {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Test
	public void countRecentScheduleByUser() {
		Assert.assertNotNull(scheduleRepository.countRecentScheduleByUser("xiweicheng"));
	}
}
