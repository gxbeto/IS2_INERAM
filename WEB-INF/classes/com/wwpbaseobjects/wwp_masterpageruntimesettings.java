package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_masterpageruntimesettings", "/com.wwpbaseobjects.wwp_masterpageruntimesettings"})
public final  class wwp_masterpageruntimesettings extends GXWebPanelStub
{
   public wwp_masterpageruntimesettings( )
   {
   }

   public wwp_masterpageruntimesettings( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_masterpageruntimesettings.class ));
   }

   public wwp_masterpageruntimesettings( int remoteHandle ,
                                         ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_masterpageruntimesettings_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_masterpageruntimesettings_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "WWP_Master Page Runtime Settings";
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

