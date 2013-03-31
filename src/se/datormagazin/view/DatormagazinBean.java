package se.datormagazin.view;  

import java.util.ArrayList;  
import java.util.List;  
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import se.datormagazin.model.Nummer;

@ManagedBean(name = "datormagazinBean")
@ApplicationScoped
public class DatormagazinBean {  

	private List<Nummer> nummer;
	private Nummer aktivtNummer;  

	public DatormagazinBean() {  
		nummer = new ArrayList<Nummer>();  
		nummer.add(new Nummer("3-2013",
				"http://bilder3.egmont.se/cache/4e/4ee9/4ee936088a9626722d6920da843173c198256965",
				"Bättre prestanda och mer lagringsutrymme för pengarna. SSD-enheternas utveckling går framåt. I Datormagazin 3-2013 testar vi 12 diskar och hittar en solklar vinnare. Temat i tidningen är smarta IT-tips för småföretagare.<br/>Några av temats höjdpunkter:<br/><ul><li>Hyr din mjukvara</li><li>22 appar som gör jobbet enklare</li><li>Automatisera installationer</li><li>Windows Server 2012</li><li>Klienthantering i molnet</li><li>Bokföring bland molnen</li></ul>Serverprocessorer handlar till stor del om Intel, AMD och ARM - men konkurrenterna står dock inte och stampar. Detta, bland mycket annat, finns att läsa i DMZ 3-2013."
				));  
		this.aktivtNummer = nummer.get(0);
		nummer.add(new Nummer("2-2013",
				"http://bilder.egmont.se/cache/dd/dd54/dd540302660013ff5e0dbfe75f06c279f9152745",
				"Testat AMD FX-8350 AMD:s senaste processor är inte särskilt strömsnål, men de åtta kärnorna tillsammans med en lockande prisbild gör den till ett intressant alternativ."
				));
		nummer.add(new Nummer("1-2013",
				"http://bilder3.egmont.se/cache/f5/f5c7/f5c730cccef18f00628b76ba6bc25efee1445559",
				"Testat - Samsung Galaxy Note II - Samsung bjuder på ett kraftpaket med riktigt bra batteritid. Det här är en gigant med en bildskärm som mäter 5,5 tum."
				));
	}  

	public List<Nummer> getNummer() {  
		return nummer;  
	}  

	public void onEdit(RowEditEvent event) {  
		FacesMessage msg = new FacesMessage(((Nummer) event.getObject()).getNamn(), " sparades!");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}  

	public void onCancel(RowEditEvent event) {  
		FacesMessage msg = new FacesMessage(((Nummer) event.getObject()).getNamn(), " sparades inte");  
		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}

	public Nummer getAktivtNummer() {
		return aktivtNummer;
	}

	public void setAktivtNummer(Nummer aktivtNummer) {
		this.aktivtNummer = aktivtNummer;
	}

	public List<Nummer> completeNummer(String query) {
		ArrayList<Nummer> matchandeNamn = new ArrayList<Nummer>();
		for (Nummer nr : nummer) {
			if (nr.getNamn().contains(query)) matchandeNamn.add(nr);
		}
		return matchandeNamn;
	}
} 