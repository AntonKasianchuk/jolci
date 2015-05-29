package jolci.annotations;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InspectTest {

	@Test
	public void shouldBeAnnotation() {
		assertTrue("Should be an annotation.", Inspect.class.isAnnotation());
	}

	@Test
	public void shouldBeUsedForTypesOnly() {
		Target targetAnnotation = Inspect.class.getAnnotation(Target.class);
		assertNotNull("Should be annotated with Target annotation.",
				targetAnnotation);

		ElementType typeExpected = ElementType.TYPE;
		ElementType[] elementTypes = targetAnnotation.value();
		List<ElementType> elementTypeList = Arrays
				.<ElementType> asList(elementTypes);
		boolean isTypeValuePresent = elementTypeList.contains(typeExpected);
		assertTrue("Target annotation should have " + typeExpected
				+ " as its value.", isTypeValuePresent);
	}
}
