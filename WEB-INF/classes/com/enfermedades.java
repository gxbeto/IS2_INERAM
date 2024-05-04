package com ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.enfermedades", "/com.enfermedades"})
public final  class enfermedades extends GXWebPanelStub
{
   public enfermedades( )
   {
   }

   public enfermedades( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( enfermedades.class ));
   }

   public enfermedades( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new enfermedades_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new enfermedades_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Enfermedades";
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

