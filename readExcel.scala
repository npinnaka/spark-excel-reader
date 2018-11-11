/*

#open spark shell with spark-excel package
spark-shell --packages com.crealytics:spark-excel_2.11:0.10.1
# use the script to get a df/ds 
*/


import org.apache.spark.sql._
  import org.apache.spark.sql.types._
  import com.crealytics.spark.excel._

  val peopleSchema = StructType
  (Array
   (StructField ("Name", StringType, nullable = false),
                StructField ("Age", LongType, nullable = false),
                StructField ("Occupation", StringType, nullable = false),
                StructField ("Date of birth", StringType, nullable = false)))


  val df = spark.read.format ("com.crealytics.spark.excel") .option ("sheetName", "Info") .option ("useHeader", "true") .option ("userSchema", "true") .schema (peopleSchema) .load ("People.xls")
