package my.wicket.app.hello;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.util.SingleSortState;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class DataProvider implements ISortableDataProvider<Customer, String>, IFilterStateLocator<Customer> {

	private CustomerService service = CustomerService.getInstance();
	
	
	private Customer searchEntity = new Customer();
	
	
	@Override
	public Iterator<? extends Customer> iterator(long first, long count) {
		return service.findAll(searchEntity.getFirstName(), (int)first, (int)count).iterator();
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return service.count();
	}


	
	@Override
	public IModel<Customer> model(Customer object) {
		return Model.of(object);
	}

	//need to implement this for sorting
	@Override
	public ISortState<String> getSortState() {
		return new SingleSortState<String>();
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

}
