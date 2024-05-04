package com.wwpbaseobjects ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "WWP_SearchResults", namespace ="Gregory")
public final  class StructSdtWWP_SearchResults implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SearchResults( )
   {
      this( -1, new ModelContext( StructSdtWWP_SearchResults.class ));
   }

   public StructSdtWWP_SearchResults( int remoteHandle ,
                                      ModelContext context )
   {
   }

   public  StructSdtWWP_SearchResults( java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="WWP_SearchResultsItem",namespace="Gregory")
   public java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtWWP_SearchResults_WWP_SearchResultsItem> item = new java.util.Vector<>();
}

