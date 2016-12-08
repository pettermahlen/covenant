package com.spotify.covenant.example;

import static com.spotify.covenant.Invocations.invoke;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.spotify.covenant.Invocation;
import com.spotify.covenant.Invocations;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * TODO: document!
 */
@RunWith(Theories.class)
public class EasyExampleProducerTest {
  EasyProducer producer;

  @Before
  public void setUp() throws Exception {
    producer = new EasyProducer();
  }

  @Theory
  public void shouldAcceptRecordedInvocations(@ParametersSuppliedBy(MySupplier.class) Invocation invocation) throws Exception {
    assertThat(
        invoke(producer, invocation.method(), invocation.args()),
        is(invocation.result()));
  }

  public static class MySupplier extends ParameterSupplier {

    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
      return Arrays.asList(
          PotentialAssignment.forValue("one", Invocations.create(EasyExample.class.getName(), "method1", "floop", Arrays.asList("string", 5711)))
      );
    }
  }
}
