package config;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryPathResolver;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class FindChanges extends JUnitStory {
	public FindChanges() {

	}

	@Override
	public Configuration configuration() {

		return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(this.getClass()))
				.useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
				.useStoryPathResolver(new StoryPathResolver() {
					@Override
					public String resolve(Class<? extends Embeddable> embeddableClass) {
						return "config/find_changes.story";
					}
				}).useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE,
						Format.TXT, Format.HTML, Format.XML));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new FindChangeSteps());
	}

}
