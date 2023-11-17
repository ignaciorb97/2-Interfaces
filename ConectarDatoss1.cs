using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Mono.Data.Sqlite;
using System.Data;
using System;
/// <summary>
/// Este es un resumen de la clase.
/// </summary>

public class ConectarDatoss1 : MonoBehaviour
{
    // Ruta a la base de datos SQLite
    string conn = "URI=file:" + Application.dataPath + "/phoneland.db";
    IDbConnection dbconn;

    // M�todo Start se llama antes del primer frame update
    void Start()
    {
        // Llamada al m�todo de conexi�n
        Conectar();
    }

    // M�todo Update se llama una vez por frame
    void Update()
    {
        // Puedes realizar operaciones adicionales en el update si es necesario
    }

    // M�todo para conectar a la base de datos SQLite
    public void Conectar()
    {
        try
        {
            // Iniciar conexi�n a la base de datos
            dbconn = (IDbConnection)new SqliteConnection(conn);
            dbconn.Open();

            // Verificar el estado de la conexi�n
            Debug.Log("Estado de la conexi�n: " + dbconn.State);

            // Ejecutar consulta SELECT
            using (IDbCommand dbcmd = dbconn.CreateCommand())
            {
                string sqlQuery = "SELECT id, nombre, password FROM juego";
                dbcmd.CommandText = sqlQuery;

                using (IDataReader reader = dbcmd.ExecuteReader())
                {
                    // Leer y mostrar resultados
                    while (reader.Read())
                    {
                        int id = reader.GetInt32(0);
                        string nombre = reader.GetString(1);
                        string password = reader.GetString(2);

                        Debug.Log($"ID: {id}, Nombre: {nombre}, Password: {password}");
                    }
                }
            }
        }
        catch (Exception e)
        {
            Debug.LogError("Error al conectar a la base de datos: " + e.Message);
        }
        finally
        {
            // Cerrar la conexi�n
            if (dbconn != null && dbconn.State != ConnectionState.Closed)
            {
                dbconn.Close();
            }
        }
    }

    // M�todo OnDestroy se llama cuando el objeto es destruido
    void OnDestroy()
    {
        // Cerrar la conexi�n en OnDestroy para asegurarse de que se cierre incluso si el objeto se destruye
        if (dbconn != null && dbconn.State != ConnectionState.Closed)
        {
            dbconn.Close();
        }
    }
}

