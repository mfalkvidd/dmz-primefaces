package se.datormagazin.converters;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import se.datormagazin.model.Nummer;
import se.datormagazin.view.DatormagazinBean;

@ManagedBean(name = "NummerConverter")
@ApplicationScoped
public class NummerConverter implements Converter {


	@ManagedProperty(value = "#{datormagazinBean}")
	private DatormagazinBean datormagazinBean;

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue != null) {
			for (Nummer nummer : datormagazinBean.getNummer()) {
				if (submittedValue.equals(nummer.getNamn())) return nummer;
			}
		}
		return null;
	}

	public void setDatormagazinBean(DatormagazinBean datormagazinBean) {
		this.datormagazinBean = datormagazinBean;
	}

	public DatormagazinBean getDatormagazinBean() {
		return datormagazinBean;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value instanceof Nummer) return ((Nummer) value).getNamn(); else return "";
	}
}

