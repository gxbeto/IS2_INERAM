package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wizardstepsarrowwc", "/com.wwpbaseobjects.wizardstepsarrowwc"})
public final  class wizardstepsarrowwc extends GXWebPanelStub
{
   public wizardstepsarrowwc( )
   {
   }

   public wizardstepsarrowwc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wizardstepsarrowwc.class ));
   }

   public wizardstepsarrowwc( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wizardstepsarrowwc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wizardstepsarrowwc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Wizard Steps Arrow WC";
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

