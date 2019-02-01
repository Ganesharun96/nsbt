using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace WindowsFormsApplication2
{
    public partial class Form1 : Form
    {
        SqlConnection con = new SqlConnection(@"Data Source=NSCHN030\SQLEXPRESS;Initial Catalog=DevPractice;User ID=prac;Password=practice");
        public Form1()
        {
            InitializeComponent();
        } 

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'devPracticeDataSet.Personsdetails' table. You can move, or remove it, as needed.
           // this.personsdetailsTableAdapter.Fill(this.devPracticeDataSet.Personsdetails);

            con.Open();
            SqlCommand sc = new SqlCommand("select * from Personsdetails", con);
            SqlDataReader sd = sc.ExecuteReader();
            if (sd.HasRows)
            {
                DataTable dt = new DataTable();
                dt.Load(sd);
                dataGridView1.DataSource = dt;
                con.Close();
            }
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
          
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            string insStmt = "insert into Personsdetails ([PersonID],[LastName],[FirstName],[Address],[City]) values (@personid,@lastName,@firstName,@address,@city)";

            using (con)
            {
                con.Open();
                SqlCommand insCmd = new SqlCommand(insStmt, con);
              //  SqlDataReader sd = insCmd.ExecuteReader();
                // use sqlParameters to prevent sql injection!
                insCmd.Parameters.AddWithValue("@personid", textBox3.Text);
                insCmd.Parameters.AddWithValue("@firstName", textBox2.Text);
                insCmd.Parameters.AddWithValue("@lastName", textBox4.Text);
                insCmd.Parameters.AddWithValue("@address", textBox1.Text);
                insCmd.Parameters.AddWithValue("@city", textBox5.Text);
                int affectedRows = insCmd.ExecuteNonQuery();
                MessageBox.Show(affectedRows + " rows inserted!");
                //   DataTable dt = new DataTable();
                 //  dt.Load(insCmd);
               //    dataGridView1.DataSource = dt;
            }
            //SqlCommand sc = new SqlCommand("select * from Personsdetails", con);
           // SqlDataReader sd = sc.ExecuteReader();
           // if (sd.HasRows)
           // {
           //     DataTable dt = new DataTable();
             //   dt.Load(sd);
             //   dataGridView1.DataSource = dt;
             //   con.Close();
           // }



        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
