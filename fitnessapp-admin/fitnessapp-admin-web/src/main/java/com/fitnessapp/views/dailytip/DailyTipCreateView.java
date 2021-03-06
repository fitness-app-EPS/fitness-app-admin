/*
 * Copyright (C) 2018 Naluem
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.fitnessapp.views.dailytip;

import com.fitnessapp.api.client.DailyTipClient;
import com.fitnessapp.api.entities.DailyTip;
import com.fitnessapp.views.specifictip.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Naluem
 */
@Named(value = "dailyTipCreateView")
@ViewScoped
public class DailyTipCreateView implements Serializable {

    private String text;

    private DailyTipClient dtc = new DailyTipClient();
    private List<DailyTip> dtl = new ArrayList<DailyTip>();

    @PostConstruct
    public void init() {
        dtc = new DailyTipClient();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void save() {
        DailyTip dt = new DailyTip();
        dt.setText(text);
        dtc.create(dt);
        addMessage("Data saved");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
