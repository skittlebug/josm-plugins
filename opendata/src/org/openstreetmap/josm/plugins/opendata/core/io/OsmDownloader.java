// License: GPL. For details, see LICENSE file.
package org.openstreetmap.josm.plugins.opendata.core.io;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;

import org.openstreetmap.josm.Main;
import org.openstreetmap.josm.plugins.opendata.core.OdConstants;

public class OsmDownloader implements OdConstants {
	
	public static final void downloadOapi(String oapiReq) {
		if (oapiReq != null) {
			try {
				String oapiServer = Main.pref.get(PREF_OAPI, DEFAULT_OAPI);
				System.out.println(oapiReq);
				String oapiReqEnc = URLEncoder.encode(oapiReq, UTF8);
				Main.main.menu.openLocation.openUrl(false, oapiServer+"data="+oapiReqEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final void downloadXapi(Collection<String> xapiReqs) {
		if (xapiReqs != null) {
			String xapiServer = Main.pref.get(PREF_XAPI, DEFAULT_XAPI);
			for (String xapiReq : xapiReqs) {
				Main.main.menu.openLocation.openUrl(false, xapiServer+xapiReq);
			}
		}
	}
}
