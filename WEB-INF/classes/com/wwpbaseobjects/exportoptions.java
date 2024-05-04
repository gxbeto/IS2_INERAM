package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.exportoptions", "/com.wwpbaseobjects.exportoptions"})
public final  class exportoptions extends GXWebPanelStub
{
   public exportoptions( )
   {
   }

   public exportoptions( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( exportoptions.class ));
   }

   public exportoptions( int remoteHandle ,
                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new exportoptions_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new exportoptions_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Opciones para Exportar a Excel";
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

