package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.menuitemww", "/com.wwpbaseobjects.menuitemww"})
public final  class menuitemww extends GXWebPanelStub
{
   public menuitemww( )
   {
   }

   public menuitemww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( menuitemww.class ));
   }

   public menuitemww( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new menuitemww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new menuitemww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Menu Item";
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

