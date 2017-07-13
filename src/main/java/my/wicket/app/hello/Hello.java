package my.wicket.app.hello;

import org.apache.wicket.page.*;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;

import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.WebPage;

import java.util.ArrayList;
import java.util.List;

import javax.management.Attribute;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeadersToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.extensions.markup.html.repeater.data.table.NavigationToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterForm;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.FilterToolbar;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.TextFilteredPropertyColumn;

public class Hello extends WebPage {

	private static final long serialVersionUID = 1L;

	public Hello(final PageParameters parameters) {

		add(new Label("message", "Hello World test, Wicket"));
		
		

		DataProvider provider = new DataProvider();
		
		// add the grid
		List<PropertyColumn> columns = new ArrayList<PropertyColumn>();
		columns.add(new PropertyColumn<String, String>(new Model<String>("Id"), "id", "id"));
		
		//filter by name
		columns.add(new TextFilteredPropertyColumn<Customer, Customer, Customer>(Model.of("firstName"), provider.getFilterState(), "firstName"));
		
		columns.add(new PropertyColumn<String, String>(new Model<String>("lastName"), "lastName", "lastName"));
		
		//column width
		PropertyColumn regDate = new PropertyColumn<String, String>(new Model<String>("registerDate"), "registerDate", "registerDate");
		regDate.getHeader("registerDate").add(new AttributeModifier("style", new Model<String>("width:200px")) );
		
		
		columns.add(regDate);
		columns.add(new PropertyColumn<String, String>(new Model<String>("status"), "status", "status"));

		FilterForm<Customer> filterForm = new FilterForm<Customer>("filterForm", provider);
		DefaultDataTable<Customer, Customer> table = new DefaultDataTable("table", columns, provider, 10);
		
		FilterToolbar filterToolbar = new FilterToolbar(table, filterForm);
		
		table.addTopToolbar(filterToolbar);
		table.addBottomToolbar(new NavigationToolbar(table));
		
		filterForm.add(table);
		
		add(filterForm);

	}
}
