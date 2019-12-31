
# Create your own measures in Power BI Desktop
 
By using measures, you can create some of the most powerful data analysis solutions in Power BI Desktop. Measures help you by performing calculations on your data as you interact with your reports. This tutorial will guide you through understanding measures and creating your own basic measures in Power BI Desktop.
 
- This tutorial is intended for Power BI users already familiar with using Power BI Desktop to create more advanced models. 
- In this lab, we get data from a CSV file. [Download the Financial Sample CSV file.](/Dataset/FinancialSample.csv)
 

1. Create new columns to a data table using a formula from another variable. In the **Add Columns** at the top of the nav pane, select the **Custom Columns** and add formula in the box description, the choose **OK**.

--- 
- Gross sale = Units Sold * Sale Price
- Sales = Gross Sale - Discount
- Profit = Sales - (Manufactoring Price + COGS)
---

![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_1.png) |
--- |


![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_2.png) |
--- |

Tips: 
- Replace values ($ >> Nan, "-" >> 0)
- Change Type: Decimal Number
- File >> Apply


2. Extract `Month Number`, `Month Name` and `Year` from `Date` field. 
([DAX Date and Time](https://docs.microsoft.com/en-us/dax/date-and-time-functions-dax) functions are similar to the Excel date and time functions. However, DAX date and time functions are based on the DAX datetime data type).

![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_3.png) |
--- |

3. Sort by `Month Name` in plot as string
  

![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_4.png) |
--- |


Tips: Data >> Modeling >> Sort by Column

4. Dealing with **Blanks**: 

    - Count the number of blank cells in a column **Segment** by using [COUNTBLANK()](https://docs.microsoft.com/en-us/dax/countblank-function-dax)

    - Get category value in **Segment** which is maximum value of **Sales**.

    - Create a new column **SegmentFull** to fill NaNs in a column **Segment** by value above. 

![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_7.png) |
--- |
 


5. Change data label displaying value of delta value by slicer. 

![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_5.png)  | ![Accessing databases](/hands-on/data-visualization-in-BI/Images/lab3_6.png)  |
--- | --- | 


---
Tips: The [UNICHAR()](https://docs.microsoft.com/en-us/dax/unichar-function-dax) function accepts an integer that maps to the character you would like to display in your visual. The easiest way to find the character you want is to consult an online resource such as [here](https://unicode-table.com/). 

---


