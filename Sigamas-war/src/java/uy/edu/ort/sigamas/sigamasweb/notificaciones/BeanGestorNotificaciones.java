/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ort.sigamas.sigamasweb.notificaciones;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import uy.edu.ort.sigamas.notificaciones.entidades.Notificacion;
import uy.edu.ort.sigamas.seguimiento.SeguimientoBeanLocal;
import uy.edu.ort.sigamas.seguimiento.entidades.Proyecto;
import uy.edu.ort.sigamas.seguridad.notificacion.NotificacionBeanLocal;
import uy.edu.ort.sigamas.sigamasweb.login.BeanSesionUsuario;

/**
 *
 * @author Mattahari
 */
@ManagedBean(name = "beanGestorNotificaciones")
@ViewScoped
public class BeanGestorNotificaciones {

    private LineChartModel lineModel1;
    private LineChartModel lineModel2;
    private int tareasPendientes = 1;
    private ScheduleModel eventModel;
    private MenuModel notificaciones;
    private List<Notificacion> notificacionesNoLeidas;
    private List<Proyecto> proyectosConTareasPendientes;

    @EJB
    private NotificacionBeanLocal notificacionBeanLocal;

    @EJB
    private SeguimientoBeanLocal seguimientoBeanLocal;

    @ManagedProperty(value = "#{beanSesionUsuario}")
    private BeanSesionUsuario beanSesionUsuario;

    /**
     * Creates a new instance of BeanGestorNotificaciones
     */
    public BeanGestorNotificaciones() {
    }

    @PostConstruct
    public void init() {

        notificacionesNoLeidas = notificacionBeanLocal.obtenerNotificacionesNoLeidas(beanSesionUsuario.getCuentaActual());

        notificaciones = new DefaultMenuModel();
        Integer menuItemId = 1;
        if (notificacionesNoLeidas != null) {
            for (Notificacion notificacion : notificacionesNoLeidas) {
                menuItemId++;
                DefaultMenuItem menuItem = new DefaultMenuItem(notificacion.getMensaje());
                menuItem.setId(menuItemId.toString());
                String notificacionId = notificacion.getIdNotificacion().toString();
                menuItem.setCommand("#{beanSesionUsuario.show('" + notificacionId + "')}");
                notificaciones.addElement(menuItem);
            }
        }

    }
    
    

    public void setBeanSesionUsuario(BeanSesionUsuario beanSesionUsuario) {
        this.beanSesionUsuario = beanSesionUsuario;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Costos estimados");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Costos reales");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    private void createLineModels() {
        setLineModel1(initLinearModel());
        getLineModel1().setTitle("Estimacion costos vs Costos reales");
        getLineModel1().setLegendPosition("e");
        Axis yAxis = getLineModel1().getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);

        setLineModel2(initCategoryModel());
        getLineModel2().setTitle("Category Chart");
        getLineModel2().setLegendPosition("e");
        getLineModel2().setShowPointLabels(true);
        getLineModel2().getAxes().put(AxisType.X, new CategoryAxis("Years"));
        yAxis = getLineModel2().getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

    private LineChartModel initCategoryModel() {
        LineChartModel model = new LineChartModel();

        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);

        model.addSeries(boys);
        model.addSeries(girls);

        return model;
    }

    /**
     * @return the lineModel1
     */
    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    /**
     * @param lineModel1 the lineModel1 to set
     */
    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    /**
     * @return the lineModel2
     */
    public LineChartModel getLineModel2() {
        return lineModel2;
    }

    /**
     * @param lineModel2 the lineModel2 to set
     */
    public void setLineModel2(LineChartModel lineModel2) {
        this.lineModel2 = lineModel2;
    }

    public void addMessage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se valido la tarea1"));

    }

    /**
     * @return the tareasPendientes
     */
    public int getTareasPendientes() {
        return tareasPendientes;
    }

    /**
     * @param tareasPendientes the tareasPendientes to set
     */
    public void setTareasPendientes(int tareasPendientes) {
        this.tareasPendientes = tareasPendientes;
    }

    public void validarTarea() {
        this.tareasPendientes = 0;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);

        return t.getTime();
    }

    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);

        return t.getTime();
    }

    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }

    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);

        return t.getTime();
    }

    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    /**
     * @return the eventModel
     */
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    /**
     * @param eventModel the eventModel to set
     */
    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public String onEventSelect(SelectEvent selectEvent) {
        //event = (ScheduleEvent) selectEvent.getObject();
        return "detalleTarea";
    }

    /**
     * @return the notificaciones
     */
    public MenuModel getNotificaciones() {
        return notificaciones;
    }

    /**
     * @param notificaciones the notificaciones to set
     */
    public void setNotificaciones(MenuModel notificaciones) {
        this.notificaciones = notificaciones;
    }

    /**
     * @return the notificacionesNoLeidas
     */
    public List<Notificacion> getNotificacionesNoLeidas() {
        return notificacionesNoLeidas;
    }

    /**
     * @param notificacionesNoLeidas the notificacionesNoLeidas to set
     */
    public void setNotificacionesNoLeidas(List<Notificacion> notificacionesNoLeidas) {
        this.notificacionesNoLeidas = notificacionesNoLeidas;
    }

    /**
     * @return the notificacionBeanLocal
     */
    public NotificacionBeanLocal getNotificacionBeanLocal() {
        return notificacionBeanLocal;
    }

    /**
     * @param notificacionBeanLocal the notificacionBeanLocal to set
     */
    public void setNotificacionBeanLocal(NotificacionBeanLocal notificacionBeanLocal) {
        this.notificacionBeanLocal = notificacionBeanLocal;
    }

    /**
     * @return the proyectosConTareasPendientes
     */
    public List<Proyecto> getProyectosConTareasPendientes() {
        return proyectosConTareasPendientes;
    }

    /**
     * @param proyectosConTareasPendientes the proyectosConTareasPendientes to
     * set
     */
    public void setProyectosConTareasPendientes(List<Proyecto> proyectosConTareasPendientes) {
        this.proyectosConTareasPendientes = proyectosConTareasPendientes;
    }

    /**
     * @return the seguimientoBeanLocal
     */
    public SeguimientoBeanLocal getSeguimientoBeanLocal() {
        return seguimientoBeanLocal;
    }

    /**
     * @param seguimientoBeanLocal the seguimientoBeanLocal to set
     */
    public void setSeguimientoBeanLocal(SeguimientoBeanLocal seguimientoBeanLocal) {
        this.seguimientoBeanLocal = seguimientoBeanLocal;
    }

}