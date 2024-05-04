package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wizardstepsverticalwc", "/com.wwpbaseobjects.wizardstepsverticalwc"})
public final  class wizardstepsverticalwc extends GXWebPanelStub
{
   public wizardstepsverticalwc( )
   {
   }

   public wizardstepsverticalwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardstepsverticalwc.class ));
   }

   public wizardstepsverticalwc( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardstepsverticalwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardstepsverticalwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Steps Vertical WC";
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

