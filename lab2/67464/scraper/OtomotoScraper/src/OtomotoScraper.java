import java.io.IOException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OtomotoScraper {
    public static void main(String[] args) {
    	String url = "https://www.otomoto.pl/osobowe/";
    	String nextUrl;
    	boolean flaga = true;
    	
    	while (flaga == true) {
    		try {
        		final Document document = Jsoup.connect(url).get();
        		//wypisanie danych ze strony
        		for(Element row1 : document.select(
        				"div.offers.list article")) {
        			if (row1.select(".ds-params-block").text().equals("")) {
        				continue;
        			}
        			else {
        				final String data = 
        						row1.select(".ds-params-block").text();
        				final String title = 
        						row1.select("[title]").text();
        				System.out.println(title + " " + data);
        			}
        			
        		}
        		
        		//znalezienie kolejnej strony
        		for(Element row : document.select(".next.abs")) {    			
        	        Element l = row.select("a").first();
        	        nextUrl = l.attr("href");
        	        System.out.println(l.attr("href"));
        	        
        	       if(url != nextUrl) {
        	    	   url = nextUrl;
        	       }
        	       else {
        	    	   flaga = false;
        	       }
        		}
        	}
        	catch (Exception e) {
        		e.printStackTrace();
        	} //koniec try catch 
             		
    	} //koniec petli while 
    	
    }
}