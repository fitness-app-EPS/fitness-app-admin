/*
 * Copyright (C) 2018 Jordi
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
package com.fitnessapp.views;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Jordi
 */
@Named(value = "muscularGroupCreateView")
@ViewScoped
public class MuscularGroupCreateView implements Serializable{
    private String muscularGroupName;
    
    @PostConstruct
    public void init() {
    }

    public String getMuscularGroupName() {
        return muscularGroupName;
    }

    public void setMuscularGroupName(String muscularGroupName) {
        this.muscularGroupName = muscularGroupName;
    }
    
    public void save() {
        addMessage("Data saved");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
