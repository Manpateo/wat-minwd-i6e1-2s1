using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using HtmlAgilityPack;
using Nancy.Json;

namespace WikiSlownikScraper
{
    public class HtmlReader
    {
        public static async void ReadSite(string url)
        {
            var httpClient = new HttpClient();
            var html = await httpClient.GetStringAsync(url);

            var htmlDocument = new HtmlDocument();
            htmlDocument.LoadHtml(html);

            var Table = htmlDocument.DocumentNode.Descendants("table")
                .Where(node => node.GetAttributeValue("class", "")
                .Equals("wikitable sortable")).ToList();

            
            var Language1 = Table[0].SelectNodes("//tbody/tr/td[1]").ToList();

            var Language2 = Table[0].SelectNodes("//tbody/tr/td[3]").ToList();

            var PhotoSrc = Table[0].SelectNodes("//tbody/tr/td[2]/a/img | //tbody/tr/td[2]/p/a/img").ToList();

            string[] PhotoUrl = new string[PhotoSrc.Count()];
            int j = 0;

            foreach (var elements in PhotoSrc)
            {
                PhotoUrl[j] = "https:" + PhotoSrc[j].Attributes["src"].Value;
                j++;
            }

            Console.WriteLine();

            int i = 0;
            List<Word> words = new List<Word>();

            foreach (var element in Language1)
            {
                try
                {
                    words.Add(new Word(Language1[i].InnerText.Trim(), Language2[i].InnerText.Trim(), PhotoUrl[i]));
                    ++i;
                }
                catch (Exception e)
                {
                    Console.WriteLine("Błąd przy wczytywaniu HTML!");
                }
            }

            var json = new JavaScriptSerializer().Serialize(words);
            Console.WriteLine(json);

        }
    }
}