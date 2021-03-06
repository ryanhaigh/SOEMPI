/**
 * 
 *  Copyright (C) 2013 Vanderbilt University <csaba.toth, b.malin @vanderbilt.edu>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.openempi.webapp.client.mvc.configuration;

import java.util.List;

import org.openempi.webapp.client.AppEvents;
import org.openempi.webapp.client.ConfigurationDataServiceAsync;
import org.openempi.webapp.client.model.MatchFieldWeb;
import org.openempi.webapp.client.mvc.AbstractController;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MatchFieldConfigurationController extends AbstractController
{
	private MatchFieldConfigurationView matchFieldConfigurationView;

	public MatchFieldConfigurationController() {		
		this.registerEventTypes(AppEvents.MatchFieldConfigurationReceived);
		this.registerEventTypes(AppEvents.MatchFieldConfigurationRequest);
		this.registerEventTypes(AppEvents.MatchFieldConfigurationSave);
		this.registerEventTypes(AppEvents.MatchFieldConfigurationView);
		this.registerEventTypes(AppEvents.MatchFieldComparisonFunctionParametersEdited);
		this.registerEventTypes(AppEvents.LeftDatasetColumnNamesArrived);
		this.registerEventTypes(AppEvents.RightDatasetColumnNamesArrived);
	}

	@Override
	protected void initialize() {
		matchFieldConfigurationView = new MatchFieldConfigurationView(this);
	}

	@Override
	public void handleEvent(AppEvent event) {
		EventType type = event.getType();
		if (type == AppEvents.MatchFieldConfigurationView) {
			forwardToView(matchFieldConfigurationView, event);
		} else if (type == AppEvents.MatchFieldConfigurationRequest) {
			requestMatchFieldConfigurationData();
		} else if (type == AppEvents.MatchFieldConfigurationSave) {
			saveMatchFieldConfiguration(event);
		} else if (type == AppEvents.MatchFieldComparisonFunctionParametersEdited) {
			forwardToView(matchFieldConfigurationView, event);
		} else if (type == AppEvents.LeftDatasetColumnNamesArrived || type == AppEvents.RightDatasetColumnNamesArrived) {
			forwardToView(matchFieldConfigurationView, event);
		}
	}

	@SuppressWarnings("unchecked")
	private void saveMatchFieldConfiguration(AppEvent event) {
		ConfigurationDataServiceAsync configurationDataService = getConfigurationDataService();
		List<MatchFieldWeb> matchFields = (List<MatchFieldWeb>) event.getData();
		configurationDataService.saveMatchFieldConfiguration(matchFields, (new AsyncCallback<String>() {
	      public void onFailure(Throwable caught) {
	      }

	      public void onSuccess(String message) {
	    	  if (message == null || message.length() == 0) {
	    		  Info.display("Information", "Match field configuration data was saved successfully.");
	    	  } else {
	    		  Info.display("Information", "Failed to save match field configuration data: " + message);
	    	  }
	      }
	    }));
	}

	private void requestMatchFieldConfigurationData() {
		ConfigurationDataServiceAsync configurationDataService = getConfigurationDataService();
		configurationDataService.loadMatchFieldConfiguration(new AsyncCallback<List<MatchFieldWeb>>() {
	      public void onFailure(Throwable caught) {
	        Dispatcher.forwardEvent(AppEvents.Error, caught);
	      }

	      public void onSuccess(List<MatchFieldWeb> result) {
	        forwardToView(matchFieldConfigurationView, AppEvents.MatchFieldConfigurationReceived, result);
	      }
	    });
	}

}
