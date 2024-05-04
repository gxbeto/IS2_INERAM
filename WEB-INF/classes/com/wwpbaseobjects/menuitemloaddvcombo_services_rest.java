package com.wwpbaseobjects ;
import com.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@javax.ws.rs.Path("/WWPBaseObjects/MenuItemLoadDVCombo")
public final  class menuitemloaddvcombo_services_rest extends GxRestService
{
   @javax.ws.rs.POST
   @javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response execute( com.wwpbaseobjects.menuitemloaddvcombo_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      String AV16ComboName;
      AV16ComboName = entity.getComboName() ;
      String AV17TrnMode;
      AV17TrnMode = entity.getTrnMode() ;
      boolean AV18IsDynamicCall;
      AV18IsDynamicCall = entity.getIsDynamicCall() ;
      short AV19MenuItemId;
      AV19MenuItemId = entity.getMenuItemId() ;
      String AV20SearchTxtParms;
      AV20SearchTxtParms = entity.getSearchTxtParms() ;
      String [] AV21SelectedValue = new String[] { "" };
      String [] AV22SelectedText = new String[] { "" };
      String [] AV23Combo_DataJson = new String[] { "" };
      if ( ! processHeaders("wwpbaseobjects.menuitemloaddvcombo",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.wwpbaseobjects.menuitemloaddvcombo worker = new com.wwpbaseobjects.menuitemloaddvcombo(remoteHandle, context);
         worker.execute(AV16ComboName,AV17TrnMode,AV18IsDynamicCall,AV19MenuItemId,AV20SearchTxtParms,AV21SelectedValue,AV22SelectedText,AV23Combo_DataJson );
         com.wwpbaseobjects.menuitemloaddvcombo_RESTInterfaceOUT data = new com.wwpbaseobjects.menuitemloaddvcombo_RESTInterfaceOUT();
         data.setSelectedValue(AV21SelectedValue[0]);
         data.setSelectedText(AV22SelectedText[0]);
         data.setCombo_DataJson(AV23Combo_DataJson[0]);
         builder = Response.okWrapped(data);
         cleanup();
         return (javax.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   @javax.ws.rs.OPTIONS
   @javax.ws.rs.Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public javax.ws.rs.core.Response optionsMethod( ) throws Exception
   {
      super.init( "OPTIONS" );
      builder = Response.options("POST, OPTIONS");
      return (javax.ws.rs.core.Response) builder.build() ;
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}

