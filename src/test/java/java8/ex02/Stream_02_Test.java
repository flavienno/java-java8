package java8.ex02;

import java8.data.Data;
import java8.data.domain.Customer;
import java8.data.domain.Order;
import java8.data.domain.Pizza;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Transformation
 */
public class Stream_02_Test {

	@Test
	public void test_map() throws Exception {

		List<Order> orders = new Data().getOrders();

		// Trouver la liste des clients ayant déjà passés une commande
		List<Customer> result1 = orders.stream().map(c -> c.getCustomer()).distinct().collect(Collectors.toList());

		// Deuxieme méthode avec des sets
		Set<Customer> result = orders.stream().map(c -> c.getCustomer()).collect(Collectors.toSet());

		assertThat(result, hasSize(2));
		assertThat(result1, hasSize(2));
	}
}