
# Get started with the Power BI service
 
This tutorial is an introduction to some of the features of the Power BI service. In it, you connect to data, create a report and a dashboard, and ask questions of your data. You can do much more in the Power BI service; this tutorial is just to whet your appetite. For an understanding of how the Power BI service fits in with the other Power BI offerings, we recommend reading What is Power BI.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-get-started-home.png)

In this tutorial, you complete the following steps:

- Sign in to your Power BI online account, or sign up, if you don't have an account yet. 
- Open the Power BI service.
- Get some data and open it in report view.
- Use that data to create visualizations and save it as a report.
- Create a dashboard by pinning tiles from the report. 
- Clean up resources by deleting the dataset, report, and dashboard.


## Sign up for the Power BI service
### Step 1: Get data
Often when you want to create a Power BI report, you start in Power BI Desktop. This time, we're going to start from scratch creating a report in the Power BI service.

In this lab, we get data from a CSV file. [Download the Financial Sample CSV file.](/hands-on/data-visualization-in-BI/Dataset/FinancialSample.csv)

1. Sign in to Power BI. Power BI opens in  your browser. Select **Get data** at the bottom of the nav pane. The **Get Data** page opens.

2. Under the **Create new content** section, select **Files**.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/gs1.png)

3. Select **Local file**.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-get-data-local-file.png)

4. Browse to the file on your computer, and choose **Open**.

5. For this tutorial, we select **Import** to add the Excel file as a dataset, which we can then use to create reports and dashboards. If you select **Upload**, the entire Excel workbook is uploaded to Power BI, where you can open and edit it in Excel online.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-import.png)

6. When your dataset is ready, select **Datasets**, then select **Create report** next to the dataset **Financial sample** to open the report editor.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-datasets.png)

The report canvas is blank. We see the **Filters**, **Visualizations**, and **Fields** panes on the right.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-blank-report.png)

7. Notice there's an option for **Reading view** on the top nav pane. Because you have this option, that means you're currently in Editing view. 

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-reading-view.png)

While in Editing view, you can create andủng modify your reports, because you're the *owner* of the report. That is, you're a *creator*. When you share your report with colleagues, they can only interact with the report in Reading view; your colleagues are *consumers*. 


### Step 2: Create a chart in a report

Now that you've connected to data, start exploring. When you've found something interesting, you can create a dashboard to monitor it and see how it changes over time. Let's see how that works.

1. In the report editor, we start in the **Fields** pane on the right side of the page to build a visualization. Select the **Gross Sales** and **Date** checkboxes.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-fields-pane-selected.png)

Power BI analyzes the data and creates a visualization. If you selected **Date** first, you see a table. If you selected **Gross Sales** first, you see a column chart.

2. Switch to a different way of displaying your data. Let's see this data as a line chart. Select the line chart icon from the **Visualizations** pane.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-select-line-chart.png)

3. Click the Format icon in the **Visualizations** panel. Then expand the **Data colors** panel and use the color picker adjacent to **Default color** to set the default color to purple.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/enhance-visualization.png)


4. This chart looks interesting, so let's pin it to a dashboard. Hover over the visualization and select the pin icon. When you pin this visualization, it's stored on your dashboard and kept up-to-date so you can track the latest value at a glance.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-pin-visual.png)

5. Because this report is new, you're prompted to save it before you can pin a visualization to a dashboard. Give your report a name (for example, Sales over time), and then select **Save**. 

6. Select **New dashboard** and name it *Financial sample for tutorial.*

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-pin.png)

7. Select **Pin**. A success message (near the top-right corner) lets you know the visualization was added as a tile to your dashboard.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-pin-success.png)

8. Select **Go to dashboard** to see your new dashboard with the line chart that you pinned to it as a tile.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-dashboard-tile.png)

9. Select the new tile on your dashboard to return to the report. Power BI returns you to the report in Reading view.

10. To switch back to Editing view, select **More options** (...) in the top nav pane > **Edit**. Back in Editing view, you can continue to explore and pin tiles.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-edit-report.png)

### Step 3: Clean up resources
Now that you've finished the tutorial, you can delete the dataset, report, and dashboard.

1. In the nav pane, make sure you're in **My Workspace**.

2. Select the **Datasets** tab and locate the dataset you imported for this tutorial.

3. Select **More options** (...) > **Delete**.

![Accessing databases](/hands-on/data-visualization-in-BI/Images/power-bi-service-delete-dataset.png)

When you delete the dataset, you see a warning that **All reports and dashboard tiles containing data from this dataset will also be deleted**.

4. Select **Delete**.
