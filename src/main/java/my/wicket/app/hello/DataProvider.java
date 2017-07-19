package my.wicket.app.hello;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.wicket.core.util.lang.PropertyResolver;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class DataProvider extends SortableDataProvider<Customer, String> implements IFilterStateLocator<Customer> {

	private CustomerService service = CustomerService.getInstance();

	private SortableDataProviderComparator comparator = new SortableDataProviderComparator();

	private Customer searchEntity = new Customer();

	public DataProvider() {
		// this.setSort(param);setSort("name.first", true);
	}

	@Override
	public Iterator<? extends Customer> iterator(long first, long count) {
		List<Customer> list = service.findAll(searchEntity.getFirstName(), (int) first, (int) count);
		Collections.sort(list, comparator);
		return list.iterator();
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return service.count();
	}

	@Override
	public IModel<Customer> model(final Customer object) {
		return new AbstractReadOnlyModel<Customer>() {
			@Override
			public Customer getObject() {
				return object;
			}
		};
	}

	@Override
	public Customer getFilterState() {
		return searchEntity;
	}

	@Override
	public void setFilterState(Customer state) {
		// TODO Auto-generated method stub
		searchEntity = state;

	}

	class SortableDataProviderComparator implements Comparator<Customer>, Serializable {
		public int compare(final Customer o1, final Customer o2) {

			if (getSort() == null || getSort().getProperty() == null) {
				return 0;
			}

			PropertyModel<Comparable> model1 = new PropertyModel<Comparable>(o1, getSort().getProperty());
			PropertyModel<Comparable> model2 = new PropertyModel<Comparable>(o2, getSort().getProperty());

			// String property = getSort().getProperty();
			//
			// Object value1 = PropertyResolver.getValue(property, o1);
			// Object value2 = PropertyResolver.getValue(property, o2);

			int result = model1.getObject().compareTo(model2.getObject());

			if (!getSort().isAscending()) {
				result = -result;
			}

			return result;
		}

	}

}
