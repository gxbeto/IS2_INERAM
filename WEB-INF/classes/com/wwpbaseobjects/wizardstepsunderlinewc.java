package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wizardstepsunderlinewc", "/com.wwpbaseobjects.wizardstepsunderlinewc"})
public final  class wizardstepsunderlinewc extends GXWebPanelStub
{
   public wizardstepsunderlinewc( )
   {
   }

   public wizardstepsunderlinewc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardstepsunderlinewc.class ));
   }

   public wizardstepsunderlinewc( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardstepsunderlinewc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardstepsunderlinewc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Steps Underline WC";
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

