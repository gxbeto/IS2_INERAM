package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.workwithplus.wwp_parameter", "/com.workwithplus.wwp_parameter"})
public final  class wwp_parameter extends GXWebPanelStub
{
   public wwp_parameter( )
   {
   }

   public wwp_parameter( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_parameter.class ));
   }

   public wwp_parameter( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_parameter_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_parameter_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parámetro";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

