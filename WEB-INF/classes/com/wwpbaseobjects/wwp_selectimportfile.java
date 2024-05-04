package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/com.wwpbaseobjects.wwp_selectimportfile", "/com.wwpbaseobjects.wwp_selectimportfile"})
public final  class wwp_selectimportfile extends GXWebPanelStub
{
   public wwp_selectimportfile( )
   {
   }

   public wwp_selectimportfile( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_selectimportfile.class ));
   }

   public wwp_selectimportfile( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_selectimportfile_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_selectimportfile_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Select file to import";
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

